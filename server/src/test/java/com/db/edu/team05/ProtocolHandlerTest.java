package com.db.edu.team05;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class ProtocolHandlerTest {
    @Test
    public void ShouldSendMessagesWhenCommandSendIsReceived() throws IOException {
        BufferedWriter stubBufWriter = mock(BufferedWriter.class);
        Session stubSession = mock(Session.class);

        Collection<Session> sessions = new ArrayList<>();
        sessions.add(stubSession);

        ProtocolHandler sutProtocolHandler = new ProtocolHandler(sessions);

        when(stubSession.isWriter()).thenReturn(false);
        when(stubSession.getOutput()).thenReturn(stubBufWriter);

        sutProtocolHandler.process("/snd test message");

        verify(stubBufWriter, times(1)).flush();
    }
}

