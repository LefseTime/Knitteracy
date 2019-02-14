/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.service;

/**
 *
 * @author sonia
 */
public class DuplicateUsername extends Exception {

    /**
     * Creates a new instance of <code>DuplicateUsername</code> without detail
     * message.
     */
    public DuplicateUsername() {
    }

    /**
     * Constructs an instance of <code>DuplicateUsername</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DuplicateUsername(String msg) {
        super(msg);
    }
}
