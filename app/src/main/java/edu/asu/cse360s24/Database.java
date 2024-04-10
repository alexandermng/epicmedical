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
		System.out.println(System.getProperty("user.home") + File.separator + "epicmedical");
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

		// DEBUG
		for (HashMap.Entry<String, Doctor> entry : data.doctors.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue().getUsername() + ", " + entry.getValue().getPassword());
		}
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
		if (data == null) {
			data = new Store();
		}
	}

	/**
	 * Saves in-memory changes to the backing store.
	 */
	void save() {
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

	public void addPatient(String id, Patient p) {
		data.patients.put(id, p);
	}

	public Store getData() {
		return data;
	}

	/**
	 * Data storage
	 */
	static class Store implements Serializable {
		private static final long serialVersionUID = 1L;
		HashMap<String, Patient> patients; // patients by ID
		HashMap<String, String> config; // idk, misc configstuffs
		HashMap<String, Doctor> doctors;
		HashMap<String, Nurse> nurses;

		public Store() {
			patients = new HashMap<String, Patient>();
			config = new HashMap<String, String>();
			doctors = new HashMap<String, Doctor>();
			nurses = new HashMap<String, Nurse>();
		}
	}
}
