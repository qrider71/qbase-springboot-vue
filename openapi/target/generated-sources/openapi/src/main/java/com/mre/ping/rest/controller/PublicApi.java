/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mre.ping.rest.controller;

import com.mre.ping.rest.model.PingResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T16:39:08.089283+01:00[Europe/Berlin]")
@Validated
@Api(value = "Public", description = "the Public API")
public interface PublicApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /ping : simple ping command takes an optional message and and optional repeat number and returns in the response the specified message the specified number of times.
     * The ping operation 
     *
     * @param message The message to be returned (optional, default to PING)
     * @param repeat Specifies how many times the message shall be repeated (optional, default to 1)
     * @return ping successfully executed (status code 200)
     *         or invalid request data (status code 400)
     *         or Internal server Error (status code 500)
     */
    @ApiOperation(value = "simple ping command takes an optional message and and optional repeat number and returns in the response the specified message the specified number of times.", nickname = "ping", notes = "The ping operation ", response = PingResponse.class, tags={ "public", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "ping successfully executed", response = PingResponse.class),
        @ApiResponse(code = 400, message = "invalid request data"),
        @ApiResponse(code = 500, message = "Internal server Error") })
    @GetMapping(
        value = "/ping",
        produces = { "application/json" }
    )
    default ResponseEntity<PingResponse> ping(@ApiParam(value = "The message to be returned", defaultValue = "PING") @Valid @RequestParam(value = "message", required = false, defaultValue="PING") String message,@Min(0)@ApiParam(value = "Specifies how many times the message shall be repeated", defaultValue = "1") @Valid @RequestParam(value = "repeat", required = false, defaultValue="1") Integer repeat) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"hostname\" : \"hostname\", \"messages\" : [ \"This is a sample ping message\", \"This is a sample ping message\" ], \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}