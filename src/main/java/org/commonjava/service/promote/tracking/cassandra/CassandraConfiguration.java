/**
 * Copyright (C) 2022 Red Hat, Inc. (https://github.com/Commonjava/service-parent)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.commonjava.service.promote.tracking.cassandra;

import io.quarkus.runtime.Startup;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Optional;

import static java.util.Optional.of;

@SuppressWarnings( { "OptionalUsedAsFieldOrParameterType", "unused" } )
@Startup
@ApplicationScoped
public class CassandraConfiguration
{
    @Inject
    @ConfigProperty( name = "cassandra.enabled", defaultValue = "false" )
    Boolean enabled;

    @Inject
    @ConfigProperty( name = "cassandra.host", defaultValue = "localhost" )
    String cassandraHost;

    @Inject
    @ConfigProperty( name = "cassandra.port", defaultValue = "9042" )
    int cassandraPort;

    @Inject
    @ConfigProperty( name = "cassandra.user" )
    Optional<String> cassandraUser;

    @Inject
    @ConfigProperty( name = "cassandra.pass" )
    Optional<String> cassandraPass;

    @Inject
    @ConfigProperty( name = "cassandra.timeoutMillis.connect", defaultValue = "60000" )
    int connectTimeoutMillis;

    @Inject
    @ConfigProperty( name = "cassandra.timeoutMillis.read", defaultValue = "60000" )
    int readTimeoutMillis;

    @Inject
    @ConfigProperty( name = "cassandra.retries.read", defaultValue = "3" )
    int readRetries;

    @Inject
    @ConfigProperty( name = "cassandra.retries.write", defaultValue = "3" )
    int writeRetries;

    @Inject
    @ConfigProperty( name = "cassandra.reconnect.delay", defaultValue = "60000" )
    long constantDelayMs;

    @Inject
    @ConfigProperty( name = "cassandra.keyspace" )
    Optional<String> keyspace;

    @Inject
    @ConfigProperty( name = "cassandra.keyspaceReplicas", defaultValue = "1" )
    int keyspaceReplicas;

    public CassandraConfiguration()
    {
    }

    public Boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled( Boolean enabled )
    {
        this.enabled = enabled;
    }

    public void setCassandraHost( String host )
    {
        cassandraHost = host;
    }

    public void setCassandraPort( Integer port )
    {
        cassandraPort = port;
    }

    public void setCassandraUser( String cassandraUser )
    {
        this.cassandraUser = of( cassandraUser );
    }

    public void setCassandraPass( String cassandraPass )
    {
        this.cassandraPass = of( cassandraPass );
    }

    public String getCassandraHost()
    {
        return cassandraHost;
    }

    public Integer getCassandraPort()
    {
        return cassandraPort;
    }

    public String getCassandraUser()
    {
        return cassandraUser.orElse( "" );
    }

    public String getCassandraPass()
    {
        return cassandraPass.orElse( "" );
    }

    public int getConnectTimeoutMillis()
    {
        return connectTimeoutMillis;
    }

    public void setConnectTimeoutMillis( int connectTimeoutMillis )
    {
        this.connectTimeoutMillis = connectTimeoutMillis;
    }

    public int getReadTimeoutMillis()
    {
        return readTimeoutMillis;
    }

    public void setReadTimeoutMillis( int readTimeoutMillis )
    {
        this.readTimeoutMillis = readTimeoutMillis;
    }

    public int getReadRetries()
    {
        return readRetries;
    }

    public void setReadRetries( int readRetries )
    {
        this.readRetries = readRetries;
    }

    public int getWriteRetries()
    {
        return writeRetries;
    }

    public void setWriteRetries( int writeRetries )
    {
        this.writeRetries = writeRetries;
    }

    public long getConstantDelayMs()
    {
        return constantDelayMs;
    }

    public void setConstantDelayMs( long constantDelayMs )
    {
        this.constantDelayMs = constantDelayMs;
    }

    public String getKeyspace()
    {
        return keyspace.orElse( "promote" );
    }

    public void setKeyspace( String keyspace )
    {
        this.keyspace = of( keyspace );
    }

    public int getKeyspaceReplicas()
    {
        return keyspaceReplicas;
    }

    public void setKeyspaceReplicas( int keyspaceReplicas )
    {
        this.keyspaceReplicas = keyspaceReplicas;
    }
}
