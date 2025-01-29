package com.aerweka.playground;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws URISyntaxException 
     */
    @Test
    public void shouldAnswerWithTrue() throws URISyntaxException
    {
        URI uri = URI.create("MessengerService");
        uri.parseServerAuthority();
        System.out.println(uri.toString() + " " + uri.getPath() + " " + uri.getScheme() + " " + uri.getAuthority() + " " + uri.getHost() + " " + uri.getPort() + " " + uri.getHost() + " " + uri.getQuery());
        assertNotNull(uri.getPath());
    }
}
