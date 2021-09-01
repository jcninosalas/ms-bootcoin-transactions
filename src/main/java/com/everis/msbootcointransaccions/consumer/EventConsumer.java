package com.everis.msbootcointransaccions.consumer;

import com.everis.msbootcointransaccions.event.Event;

public interface EventConsumer<T extends Event> {
    void consumeEvent(T event);
}