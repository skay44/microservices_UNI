package aui.skay44.lab3.event.repository.api;

import java.util.UUID;

public interface AsteroidEventRepository {
    void delete(UUID id);
    void put(UUID id);
}
