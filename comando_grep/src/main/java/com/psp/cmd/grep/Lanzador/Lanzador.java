package com.psp.cmd.grep.Lanzador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.psp.cmd.grep.Grep.Grep;

public class Lanzador {
    private static final String MSG_ERROR = "Error en la ejecución del comando";
    public static void main(String[] args) throws IOException {
        
        Process process = Runtime.getRuntime().exec (Grep.COMANDO);
        OutputStream out = process.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
                    pw.println("Me gusta PSP y Java");
                    pw.println("PSP se programa en Java");
                    pw.println("es un módulo de DAM");
                    pw.println("y se programa de forma concurrente en PSP");
                    pw.println("PSP es programación");

                    pw.close();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = br.readLine()) != null) { 
                System.out.println(linea);
            }

            int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.exit(0);
			} else {
				System.out.println(MSG_ERROR);
				System.exit(1);
			}
        
        } catch (InterruptedException e) {
            e.getMessage();
        }

    }
}