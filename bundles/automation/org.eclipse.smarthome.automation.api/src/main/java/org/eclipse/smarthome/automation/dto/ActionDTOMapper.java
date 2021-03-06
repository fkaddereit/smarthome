/**
 * Copyright (c) 2014,2017 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.smarthome.automation.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.smarthome.automation.Action;
import org.eclipse.smarthome.config.core.Configuration;

/**
 * This is a utility class to convert between the respective object and its DTO.
 *
 * @author Markus Rathgeb - Initial contribution and API
 */
public class ActionDTOMapper extends ModuleDTOMapper {

    public static ActionDTO map(final Action action) {
        final ActionDTO actionDto = new ActionDTO();
        fillProperties(action, actionDto);
        actionDto.inputs = action.getInputs();
        return actionDto;
    }

    public static Action mapDto(final ActionDTO actionDto) {
        final Action action = new Action(actionDto.id, actionDto.type, new Configuration(actionDto.configuration),
                actionDto.inputs);
        action.setLabel(actionDto.label);
        action.setDescription(actionDto.description);
        return action;
    }

    public static List<ActionDTO> map(final Collection<Action> actions) {
        if (actions == null) {
            return null;
        }
        final List<ActionDTO> dtos = new ArrayList<ActionDTO>(actions.size());
        for (final Action action : actions) {
            dtos.add(map(action));
        }
        return dtos;
    }

    public static List<Action> mapDto(final Collection<ActionDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        final List<Action> actions = new ArrayList<Action>(dtos.size());
        for (final ActionDTO dto : dtos) {
            actions.add(mapDto(dto));
        }
        return actions;
    }

}
