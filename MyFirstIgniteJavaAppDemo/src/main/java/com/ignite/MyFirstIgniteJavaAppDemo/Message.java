package com.ignite.MyFirstIgniteJavaAppDemo;

import java.util.Scanner;

import javax.cache.event.CacheEntryEvent;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicSequence;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.ContinuousQuery;

public class Message 
{
	public Message(String author, String text) 
	{
        this.author = author;
        this.text = text;
    }
    final String author;
    final String text;
	
}
