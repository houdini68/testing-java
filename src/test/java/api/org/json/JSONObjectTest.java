package api.org.json;

import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.Test;

public class JSONObjectTest {

    @Test
    public void givenJSONObject_thenOK() {

        String result = "{\"fields\":{\"summary\":\"No REST for the Wicked.\",\"issueType\":{\"id\":\"61\"},\"customfield_14370\":\"GCIT2020-34\",\"project\":{\"id\":\"16900\"},\"description\":\"Creating of an issue using ids for projects and issue types using the REST API\",\"reporter\":{\"name\":\"M999RVI\"}}}";

        JSONObject fields = new JSONObject();

        JSONObject project = new JSONObject();
        project.put("id", "16900");
        fields.put("project", project);

        fields.put("summary", "No REST for the Wicked.");

        fields.put("description", "Creating of an issue using ids for projects and issue types using the REST API");

        JSONObject issueType = new JSONObject();
        issueType.put("id", "61");

        fields.put("issueType", issueType);

        JSONObject reporter = new JSONObject();
        reporter.put("name", "M999RVI");

        fields.put("reporter", reporter);

        fields.put("customfield_14370", "GCIT2020-34");

        JSONObject root = new JSONObject();
        root.put("fields", fields);

        Assertions.assertThat(root.toString()).isEqualTo(result);
    }
}
