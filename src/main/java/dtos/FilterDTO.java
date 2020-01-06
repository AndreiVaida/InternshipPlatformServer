package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilterDTO {
    public List<String> industries;
    public List<String> cities;
    public String earliestStartDate;
    public String latestEndDate;
}
