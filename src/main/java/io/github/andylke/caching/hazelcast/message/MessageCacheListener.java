package io.github.andylke.caching.hazelcast.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.EntryUpdatedListener;

@Component
public class MessageCacheListener
    implements EntryAddedListener<String, Message>,
        EntryUpdatedListener<String, Message>,
        EntryRemovedListener<String, Message> {

  private static final Logger LOGGER = LoggerFactory.getLogger(MessageCacheListener.class);

  @Override
  public void entryAdded(EntryEvent<String, Message> event) {
    LOGGER.info("Message {} added", event);
  }

  @Override
  public void entryUpdated(EntryEvent<String, Message> event) {
    LOGGER.info("Message {} updated", event);
  }

  @Override
  public void entryRemoved(EntryEvent<String, Message> event) {
    LOGGER.info("Message {} removed", event);
  }
}
