/*
 *
 *  * Licensed to the Apache Software Foundation (ASF) under one or more
 *  *  contributor license agreements.  The ASF licenses this file to You
 *  * under the Apache License, Version 2.0 (the "License"); you may not
 *  * use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.  For additional information regarding
 *  * copyright in this work, please see the NOTICE file in the top level
 *  * directory of this distribution.
 *
 */
package org.apache.usergrid.corepersistence;

import org.safehaus.guicyfig.Default;
import org.safehaus.guicyfig.FigSingleton;
import org.safehaus.guicyfig.GuicyFig;
import org.safehaus.guicyfig.Key;

/**
 * em fig
 */
@FigSingleton
public interface EntityManagerFig extends GuicyFig {

    @Key( "usergrid.entitymanager_poll_timeout_ms" )
    @Default( "5000" )
    int pollForRecordsTimeout();

    @Key( "usergrid.entityManager_sleep_ms" )
    @Default( "100" )
    int sleep();

    @Key( "usergrid.entityManager.enable_deindex_on_update" )
    @Default( "false" )
    boolean getDeindexOnUpdate();

    /**
     * Comma-separated list of one or more Amazon regions to use if multiregion
     * is set to true.
     */
    @Key( "usergrid.queue.regionList" )
    @Default("us-east-1")
    String getRegionList();

}
