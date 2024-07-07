package br.com.ignite.exceptions;

public class CursosNotFoundException extends RuntimeException {
  public CursosNotFoundException() {
    super("Curso não encontrado.");
  }
}
