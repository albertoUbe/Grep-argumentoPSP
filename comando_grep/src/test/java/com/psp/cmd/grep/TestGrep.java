package com.psp.cmd.grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.psp.cmd.grep.Grep.Grep;

public class TestGrep {
    
@Test
void testCommando(){
    assertEquals("grep -i psp", Grep.COMANDO, "Error, el comando a usar es grep -i psp");
}

@Test
void testProceso() throws IOException, InterruptedException {
    Process process = Runtime.getRuntime().exec(Grep.COMANDO);

    try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(process.getOutputStream()))) {
        pw.println("Me gusta PSP y Java");
        pw.println("PSP se programa en Java");
        pw.println("es un módulo de DAM");
        pw.println("y se programa de forma concurrente en PSP");
        pw.println("PSP es programación");
    }

    StringBuilder resultado = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            resultado.append(linea).append("\n");
        }
    }

    int exitVal = process.waitFor();

    assertEquals(0, exitVal, "Proceso finalizado");

    String salida = resultado.toString().toLowerCase();
    assertTrue(salida.contains("psp"), "La salida debería contener la palabra 'psp'");
}


}
