package Exceptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VPF
 */
public class WrongSpawnPlaceException extends Exception {
    public WrongSpawnPlaceException(String errorMessage) {
        super(errorMessage);
    }
}
