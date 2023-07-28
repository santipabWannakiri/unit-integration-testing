package com.softwaretesting.model.request;

import com.softwaretesting.model.Application;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestAddInfluencer {
    @NotBlank(message = "is mandatory")
    private String name;
    @NotBlank(message = "is mandatory")
    private String email;
    private String app_name;
    @Size(min = 4, max = 60, message = "Channel name must be between 5 and 60 characters")
    private String channel_name;

    public RequestAddInfluencer() {
    }

    public RequestAddInfluencer(String name, String email, String app_name, String channel_name) {
        this.name = name;
        this.email = email;
        this.app_name = app_name;
        this.channel_name = channel_name;
    }
}
