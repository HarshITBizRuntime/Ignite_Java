package com.ignite.MyFirstIgniteJavaAppDemo;
import java.util.Scanner;

import javax.cache.event.CacheEntryEvent;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicSequence;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.ContinuousQuery;
public class MessageDemo
{
	public static void main(String[] args) 
	{
		try (Ignite ignite = Ignition.start("examples/config/example-ignite.xml"))
	    {
			System.out.print("Hi, enter your name: ");
			Scanner consoleScanner = new Scanner(System.in);
			String name = consoleScanner.nextLine();
			IgniteCache<Long, Message> cache = ignite.getOrCreateCache("chat");		// Get or create cache
			IgniteAtomicSequence messageId = ignite.atomicSequence("chatId", 0, true);			// Initialize unique ID sequence
			ContinuousQuery<Long, Message> qry = new ContinuousQuery<>();			// Set up continuous query
			qry.setLocalListener(iterable -> 
			{
			    for (CacheEntryEvent<? extends Long, ? extends Message> evt : iterable)			    	// This will be invoked immediately on each cache update
			        System.out.println(evt.getValue().author + ": " + evt.getValue().text);
			});
			cache.query(qry);
			while (true) 
			{
			    System.out.print(">");
			    String msgText = consoleScanner.nextLine();
			    Long msgId = messageId.incrementAndGet();
			    cache.put(msgId, new Message(name, msgText));
			}
	    }
	}
}
