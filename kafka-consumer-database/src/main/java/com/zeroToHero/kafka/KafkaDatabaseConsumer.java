package com.zeroToHero.kafka;

import com.zeroToHero.entity.WikimediaData;
import com.zeroToHero.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private final WikimediaDataRepository dataRepository;
    private final WikimediaData wikimediaData;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository, WikimediaData wikimediaData) {
        this.dataRepository = dataRepository;
        this.wikimediaData = wikimediaData;
    }

    //SpringFramework.kafka....
    @KafkaListener(topics = "wikimedia_recent_change",groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received ->%s", eventMessage));
        wikimediaData.setWikiEventData(eventMessage);
        dataRepository.save(wikimediaData);
    }
}
