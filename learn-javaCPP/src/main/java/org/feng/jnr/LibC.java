package org.feng.jnr;

public interface LibC {
    int puts(String s); // mapping of the puts function, in C `int puts(const char *s);`

    double pow(double x, double y);
}
