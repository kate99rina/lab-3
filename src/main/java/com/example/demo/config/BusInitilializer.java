package com.example.demo.config;
import net.progruzovik.bus.replication.Replicator;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import com.example.demo.dao.StudJdbc;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Component
@DependsOn("busHandler")
public class BusInitilializer {
        private final Replicator replicator;
        private final StudJdbc studentJdbc;
        public BusInitilializer(Replicator replicator, StudJdbc studentJdbc) {
            this.replicator = replicator;
            this.studentJdbc = studentJdbc;
        }
        @PostConstruct
        public void init() throws IOException {
            initEntity("student", studentJdbc.getallStudLocal());
        }
        private <T> void initEntity(String name, List<T> data) throws IOException {
            replicator.initializeEntity(name);
            for (T row : data) {
                replicator.addRow(name, row);
            }
        }

}
