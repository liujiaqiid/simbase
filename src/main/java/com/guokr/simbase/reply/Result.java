package com.guokr.simbase.reply;

import java.nio.ByteBuffer;
import java.util.SortedMap;

import org.wahlque.net.transport.Payload;
import org.wahlque.net.transport.Reply;
import org.wahlque.net.transport.payload.Bytes;
import org.wahlque.net.transport.payload.Multiple;

public class Result extends Multiple implements Reply<Payload<?>[]> {

	public Result(SortedMap<Integer, Float> result) {
		super(null);
		
		int len = 2 * result.size();
		this.value = new Bytes[len];
		//this.value[0] = new Bytes("result".getBytes());
		
		//ByteBuffer bb = null;
		int i = 0;
		for (int docid : result.keySet()) {
//			bb = ByteBuffer.allocate(4);
//			bb.putFloat(result.get(docid));
//			this.value[--len] = new Bytes(bb.array());
//
//			bb = ByteBuffer.allocate(4);
//			bb.putInt(docid);
//			this.value[--len] = new Bytes(bb.array());
			//debug
			this.value[i++] = new Bytes(String.valueOf(docid).getBytes());
			this.value[i++] = new Bytes(String.valueOf(result.get(docid)).getBytes());
		}

	}

}
