package org.alfa.pharmax.api.dtos.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TicketFilter {

    private String name;
    private String vehicle;
    private String filter;
    
    private Boolean active = Boolean.TRUE;
    
    public String getName() {
        if (name == null)
            return "";

        return name;
    }

    public String getVehicle() {
        if (vehicle == null)
            return "";

        return vehicle;
    }
    public String getFilter() {
        if (filter == null)
            return "";

        return filter;
    }
}
