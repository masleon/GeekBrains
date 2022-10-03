package ru.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ProductService {
    @Qualifier(value = "trueRepo")
    @Autowired
    private Repository inMemoryRepository;

    @Autowired
    private FileOutputStream out;

    public String getTitleById(Long id){
        return inMemoryRepository.findById(id).getTitle();
    }

    public void write() throws IOException {
        out.write("HELLO".getBytes(StandardCharsets.UTF_8));
        out.flush();

    }
}
