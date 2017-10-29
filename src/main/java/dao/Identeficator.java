package dao;

import java.io.Serializable;

public interface Identeficator<T extends Serializable> {
    T getId();
}
