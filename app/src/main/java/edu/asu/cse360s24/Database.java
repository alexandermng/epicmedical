package edu.asu.cse360s24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Database {
	private File dir; // storage directory
	private File backing; // backing file store
	private Store data; // actual data

	public Database() {
		this(System.getProperty("user.home") + File.separator + "epicmedical");
	}

	public Database(String path) {
		dir = new File(path);
		if (!dir.exists())
			dir.mkdirs();
		backing = new File(dir, "data.bin");
		if (!backing.exists())
			try {
				backing.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		load();
	}

	/**
	 * Reads in from backing store into memory. Overwrites unsaved changes.
	 */
	void load() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(backing))) {
			data = (Store) ois.readObject();
		} catch (FileNotFoundException e) {
			System.err.println("Could not find database store");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Saves in-memory changes to the backing store.
	 */
	void save() {
		// TODO: test if repeat calls overwrite or append
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(backing))) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves (or creates if necessary) a patient by ID.
	 * 
	 * @param id the unique identifier of a patient
	 * @return a Patient from the given ID
	 */
	public Patient getPatient(String id) {
		return data.patients.getOrDefault(id, new Patient(id));
	}

	class Store implements Serializable {
		HashMap<String, Patient> patients; // patients by ID
		HashMap<String, String> config; // idk, misc configstuffs
	}
}
