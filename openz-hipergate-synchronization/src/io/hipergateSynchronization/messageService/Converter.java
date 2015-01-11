/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hipergateSynchronization.messageService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class for serializing and deserializing objects.
 * 
 * @author HAWAI
 */
public class Converter<T> {

	/**
	 * Serializes an object and provides the byte-array of the serialization.
	 * @param obj Object to serialize.
	 * @return Byte-array with the serialized object.
	 * @throws IOException Serialization failed...
	 */
	public static <T> byte[] serialize(T obj) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(obj);
		return out.toByteArray();
	}

	/**
	 * Deserializes a byte-array and retrieves the object from the byte-array.
	 * @param data Byte-array, which shall be deserialized.
	 * @return Deserialized object from the byte-array.
	 * @throws IOException Deserialization failed...
	 * @throws ClassNotFoundException Class can't be found within the current environment.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(byte[] data) throws IOException,
			ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		return ((T) new ObjectInputStream(in).readObject());
	}
}
