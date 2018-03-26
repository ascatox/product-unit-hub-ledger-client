/*
 *
 *  Copyright 2016,2017 DTCC, Fujitsu Australia Software Technology, IBM - All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package it.eng.productunithubledgerclient.utils;


import it.eng.productunithubledgerclient.api.config.ConfigManager;
import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.model.ChassisDTO;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class Utils {


    public static void getMessageViolations(Set<ConstraintViolation<ChassisDTO>> violations) throws ProductUnitHubException {
        if (violations.isEmpty())
            return ;
        StringBuilder messageBuilder = new StringBuilder();
        for (ConstraintViolation violation : violations) {
            messageBuilder.append(violation.getMessage());
        }
        if (StringUtils.isNotEmpty(messageBuilder.toString()))
            throw new ProductUnitHubException(messageBuilder.toString());
    }



}
