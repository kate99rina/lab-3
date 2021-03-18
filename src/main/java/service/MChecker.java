package service;
import net.progruzovik.bus.message.RestReceiver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;

@Service
public class MChecker {
    private volatile Instant lastCheckTime = null;
    private final RestReceiver restReceiver;
    public MChecker(RestReceiver restReceiver) {
        this.restReceiver = restReceiver;
    }
    @Scheduled(fixedDelay = 3000)
    public synchronized void checkMessages() throws IOException {
        lastCheckTime = restReceiver.receiveMessages(lastCheckTime);
    }

}
