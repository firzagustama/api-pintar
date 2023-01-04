package corp.bi.go.id.api.pintar.application.facade;

import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.api.pintar.application.PintarApplicationTest;
import corp.bi.go.id.api.pintar.application.config.KhazanahFacadeTestConfig;
import corp.bi.go.id.api.pintar.facade.response.Khazanah;
import org.junit.Test;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(KhazanahFacadeTestConfig.class)
public class KhazanahFacadeTest extends PintarApplicationTest {

    @Test
    public void getKhazanah_success() throws Exception {
        String khazanahId = "123";

        ApiResponse<Khazanah> response = get("/khazanah?id=" + khazanahId, Khazanah.class);
        assertEquals(response.getResponseCode(), "1000");
        assertEquals(response.getResponseMessage(), "success");

        Khazanah responseData = response.getResponseData();
        assertEquals(responseData.getId(), khazanahId);
    }
}