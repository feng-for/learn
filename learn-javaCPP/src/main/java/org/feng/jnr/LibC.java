package org.feng.jnr;

import jnr.ffi.annotations.In;

public interface LibC {
    int setenv(@In String name, @In String value, @In boolean overwrite);

    int unsetenv(@In String name);

    String getenv(@In String name);

    int clearenv();
}
