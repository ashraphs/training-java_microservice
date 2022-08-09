package com.dlt.mbbtraining.mbbmasterdata.controllers;

import com.dlt.mbbtraining.mbbmasterdata.controllers.request.SystemConfigRequest;
import com.dlt.mbbtraining.mbbmasterdata.entities.SystemConfiguration;
import com.dlt.mbbtraining.mbbmasterdata.repositories.SystemConfigRepository;
import com.dlt.mbbtraining.mbbmasterdata.utils.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by Amir on 12/4/2019 1:54 PM
 */

@Slf4j
@RestController
@RequestMapping(value = {"/system-configurations"})
public class SystemConfigurationController {

    @Autowired
    private SystemConfigRepository configurationRepository;


    /**
     * GET ALL LIST OF SYSTEM CONFIGURATION
     * @return response of System configuration
     */
    @GetMapping
    public ResponseEntity<List<SystemConfiguration>> findAll() {

        return ResponseEntity.ok(configurationRepository.findAll());
    }

    /**
     * GET ONE SYSTEM CONFIGURATION
     * @param name = name of configuration to filter parameter
     * @return response of System configuration
     */
    @GetMapping(value = "/find-system-config-by-name")
    public ResponseEntity findByName(@RequestParam final String name) {
        SystemConfiguration systemConfiguration = configurationRepository.findByNameAndActiveIsTrueAndDeletedIsFalse(name);
        if (systemConfiguration != null) {
            return new ResponseEntity<>(systemConfiguration, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * CREATE ONE NEW SYSTEM CONFIGURATION
     * @param systemConfig = body request of system configuration
     * @param bindingResult = result of the validation by checking whether got error or not
     * @return response of System configuration
     */
    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody SystemConfigRequest systemConfig, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(
                    new ApiError(HttpStatus.BAD_REQUEST, "Name, value and type request body cannot be null"),
                    HttpStatus.BAD_REQUEST);
        }

        if (Optional.ofNullable(configurationRepository.findByNameAndActiveIsTrueAndDeletedIsFalse(systemConfig.getName())).isPresent()) {
            return new ResponseEntity<>(
                    new ApiError(HttpStatus.BAD_REQUEST, "System Config name has already been taken."),
                    HttpStatus.BAD_REQUEST);
        } else {
            SystemConfiguration newSystemConfig = new SystemConfiguration();
            newSystemConfig.setName(systemConfig.getName());
            newSystemConfig.setValue(systemConfig.getValue());
            newSystemConfig.setType(systemConfig.getType());
            newSystemConfig = configurationRepository.save(newSystemConfig);
            return new ResponseEntity<>(newSystemConfig, HttpStatus.CREATED);
        }
    }

    /**
     * UPDATE SYSTEM CONFIGURATION
     * @param id = system configuration id
     * @param systemConfig = request body
     * @param bindingResult = result of the validation by checking whether got error or not
     * @return response of System configuration
     */
    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> update(@PathVariable String id, @Valid @RequestBody SystemConfigRequest systemConfig, BindingResult bindingResult) {
        log.info("ID: {}",id);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(
                    new ApiError(HttpStatus.BAD_REQUEST, "Name, value and type request body cannot be null"),
                    HttpStatus.BAD_REQUEST);
        }

        Optional<SystemConfiguration> current = configurationRepository.findById(id);
        if (!current.isPresent()) {
            return ResponseEntity.notFound().build();
        } else if (!current.get().getName().equals(systemConfig.getName())
                && configurationRepository.findByNameAndActiveIsTrueAndDeletedIsFalse(systemConfig.getName()) != null) {
            return new ResponseEntity<>(
                    new ApiError(HttpStatus.BAD_REQUEST, "System Config name has already been taken."),
                    HttpStatus.BAD_REQUEST);
        } else {
            current.get().setName(systemConfig.getName());
            current.get().setValue(systemConfig.getValue());
            current.get().setType(systemConfig.getType());

            SystemConfiguration updateSystemConfig = configurationRepository.save(current.get());
            return ResponseEntity.ok().body(updateSystemConfig);
        }
    }

    /**
     * DELETE SYSTEM CONFIGURATION
     * @param id = system configuration id
     * @return response of System configuration
     */
    @DeleteMapping
    public ResponseEntity delete(@RequestParam String id) {
        Optional<SystemConfiguration> current = configurationRepository.findById(id);

        return current.map(result -> {
            configurationRepository.delete(result.getId());
            return new ResponseEntity(HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
