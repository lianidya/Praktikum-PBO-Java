/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputValidator {
    public static boolean isValidId(String id) {
        return id != null && id.matches("\\d+");
    }
    
    public static boolean isValidJudul(String judul) {
        return judul != null && !judul.trim().isEmpty();
    }
    
    public static LocalDate parseDate(String dateStr) throws IllegalArgumentException {
        try {
            return LocalDate.parse(dateStr);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Format tanggal harus YYYY-MM-DD");
        }
    }
}