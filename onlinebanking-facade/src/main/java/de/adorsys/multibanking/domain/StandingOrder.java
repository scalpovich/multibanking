/*
 * Copyright 2018-2019 adorsys GmbH & Co KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.adorsys.multibanking.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StandingOrder {

    private String creditorName;
    private String creditorAccount;
    private Amount transactionAmount;
    private String remittanceInformationUnstructured;
    private String bankTransactionCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private String executionRule;
    private Frequency frequency;
    private int dayOfExecution;
}
