/*
 *  *
 * ProActive Parallel Suite(TM): The Java(TM) library for
 *    Parallel, Distributed, Multi-Core Computing for
 *    Enterprise Grids & Clouds
 *
 * Copyright (C) 1997-2015 INRIA/University of
 *                 Nice-Sophia Antipolis/ActiveEon
 * Contact: proactive@ow2.org or contact@activeeon.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; version 3 of
 * the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 *
 *  Initial developer(s):               The ProActive Team
 *                        http://proactive.inria.fr/team_members.htm
 *  Contributor(s):
 *
 *  * $$ACTIVEEON_INITIAL_DEV$$
 */
package org.ow2.proactive.scheduling.api.client.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import static org.ow2.proactive.scheduling.api.client.bean.Constants.QUOTE;

@Data
public class KeyValueInput implements ApiType {
    private final String queryString;

    private KeyValueInput(String queryString) {
        this.queryString = queryString;
    }

    public static class Builder {
        private String key;
        private String value;

        private StringBuilder sb = new StringBuilder();

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public KeyValueInput build() {
            sb.append("{");
            if (StringUtils.isNotBlank(this.key)) {
                sb.append(" key : ").append(QUOTE);
                sb.append(this.key).append(QUOTE);
            }
            if (StringUtils.isNotBlank(this.value)) {
                sb.append(" value : ").append(QUOTE);
                sb.append(this.value).append(QUOTE);
            }
            sb.append(" }");
            return new KeyValueInput(sb.toString());
        }
    }
}
