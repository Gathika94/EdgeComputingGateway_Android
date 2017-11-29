package org.wso2.androidtv.agent.subscribers;

import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.stream.input.source.SourceEventListener;

import java.util.Calendar;

/**
 * Created by gathikaratnayaka on 10/27/17.
 */

public class PersistenceSubscriber {
    private SourceEventListener sourceEventListener;


    public PersistenceSubscriber(SourceEventListener sourceEventListener){
        this.sourceEventListener = sourceEventListener;
    }

    public void recieveEvent(String wrapper, String topic){
        String event ="{\"event\":{\"topic\":"+topic+","+"\"wrapper\":"+wrapper+"}}";
        System.out.println("jsonEvent: "+event);
        sourceEventListener.onEvent(event,null);
    }
}
