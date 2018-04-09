package com.ignite.MyFirstIgniteJavaAppDemo;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
public class HelloWorld 
{
	public static void main(String[] args) throws IgniteException
	{
	    try (Ignite ignite = Ignition.start("examples/config/example-ignite.xml"))
	    {
	      IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCache"); // Put values in cache.
	      cache.put(1, "Hello");
	      cache.put(2, "World!");	      // Get values from cache // Broadcast 'Hello World' on all the nodes in the cluster.
	      cache.put(1, "How Are You ?");
	      ignite.compute().broadcast(()->System.out.println(cache.get(1) + " " + cache.get(2)));
	    }
	  }
}
