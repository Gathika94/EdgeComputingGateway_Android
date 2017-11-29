package org.wso2.androidtv.agent.siddhiSources;


import org.wso2.androidtv.agent.services.DeviceManagementService;
import org.wso2.androidtv.agent.subscribers.PersistenceSubscriber;
import org.wso2.siddhi.annotation.Example;
import org.wso2.siddhi.annotation.Extension;
import org.wso2.siddhi.annotation.Parameter;
import org.wso2.siddhi.annotation.util.DataType;
import org.wso2.siddhi.core.config.SiddhiAppContext;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.exception.ConnectionUnavailableException;
import org.wso2.siddhi.core.stream.input.source.Source;
import org.wso2.siddhi.core.stream.input.source.SourceEventListener;
import org.wso2.siddhi.core.util.config.ConfigReader;
import org.wso2.siddhi.core.util.transport.OptionHolder;

import java.util.Map;

/**
 * Created by gathikaratnayaka on 10/29/17.
 */
@Extension(
        name = "persist",
        namespace="source",
        description = "Get data to be saved in a table",
        examples = @Example(description = "TBD",syntax = "TBD")
)

public class PersistSource extends AbstractEdgeSource {

    protected PersistenceSubscriber persistenceSubscriber;

    @Override
    public void init(SourceEventListener sourceEventListener, OptionHolder optionHolder, String[] strings, ConfigReader configReader, SiddhiAppContext siddhiAppContext) {
        super.init(sourceEventListener,optionHolder,strings,configReader,siddhiAppContext);
        this.persistenceSubscriber=new PersistenceSubscriber(this.sourceEventListener);

    }
    @Override
    public Class[] getOutputEventClasses() {
        return new Class[]{String.class};
    }

    @Override
    public void connect(ConnectionCallback connectionCallback) throws ConnectionUnavailableException {
        DeviceManagementService.connectToPersistenceSource(this.persistenceSubscriber);
    }

    @Override
    public void disconnect() {
       DeviceManagementService.disConnectToPersistenceSource(this.persistenceSubscriber);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public Map<String, Object> currentState() {
        return null;
    }

    @Override
    public void restoreState(Map<String, Object> map) {

    }
}
