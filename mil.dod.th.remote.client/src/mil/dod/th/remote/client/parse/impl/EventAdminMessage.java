//==============================================================================
// This software is part of the Open Standard for Unattended Sensors (OSUS)
// reference implementation (OSUS-R).
//
// To the extent possible under law, the author(s) have dedicated all copyright
// and related and neighboring rights to this software to the public domain
// worldwide. This software is distributed without any warranty.
//
// You should have received a copy of the CC0 Public Domain Dedication along
// with this software. If not, see
// <http://creativecommons.org/publicdomain/zero/1.0/>.
//==============================================================================
package mil.dod.th.remote.client.parse.impl;

import com.google.protobuf.Message;
import com.google.protobuf.ProtocolMessageEnum;

import mil.dod.th.core.remote.proto.EventMessages.EventAdminNamespace;
import mil.dod.th.core.remote.proto.RemoteBase.Namespace;
import mil.dod.th.core.remote.proto.RemoteBase.TerraHarvestMessage;
import mil.dod.th.core.remote.proto.RemoteBase.TerraHarvestPayload;
import mil.dod.th.remote.client.RemoteMessage;

/**
 * Represents a remote message for the {@link Namespace#EventAdmin} namespace.
 * 
 * @author dlandoll
 */
public class EventAdminMessage implements RemoteMessage<EventAdminNamespace>
{
    private final TerraHarvestMessage m_RawMessage;
    private final TerraHarvestPayload m_PayloadMessage;
    private final EventAdminNamespace m_NamespaceMessage;
    private final Message m_DataMessage;

    /**
     * Creates a new remote message for the {@link Namespace#EventAdmin} namespace.
     * 
     * @param rawMessage
     *      raw message everything was parsed from
     * @param payloadMessage
     *      payload message parsed from the raw {@link TerraHarvestMessage}
     * @param namespaceMessage
     *      namespace message parsed from the {@link TerraHarvestPayload}
     * @param dataMessage
     *      data message parsed from the namespace message (if applicable)
     */
    public EventAdminMessage(final TerraHarvestMessage rawMessage, final TerraHarvestPayload payloadMessage,
        final EventAdminNamespace namespaceMessage, final Message dataMessage)
    {
        m_RawMessage = rawMessage;
        m_PayloadMessage = payloadMessage;
        m_NamespaceMessage = namespaceMessage;
        m_DataMessage = dataMessage;
    }

    @Override
    public TerraHarvestMessage getRawMessage()
    {
        return m_RawMessage;
    }

    @Override
    public Namespace getNamespace()
    {
        return m_PayloadMessage.getNamespace();
    }

    @Override
    public EventAdminNamespace getNamespaceMessage()
    {
        return m_NamespaceMessage;
    }

    @Override
    public ProtocolMessageEnum getDataMessageType()
    {
        return m_NamespaceMessage.getType();
    }

    @Override
    public Message getDataMessage()
    {
        return m_DataMessage;
    }

    @Override
    public boolean isError()
    {
        return false;
    }

    @Override
    public boolean isResponse()
    {
        return m_RawMessage.getIsResponse();
    }

    @Override
    public int getSrcId()
    {
        return m_RawMessage.getSourceId();
    }

    @Override
    public int getDestId()
    {
        return m_RawMessage.getDestId();
    }
}
