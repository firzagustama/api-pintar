package corp.bi.go.id.api.pintar.application.facade;

import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.api.pintar.application.PintarApplicationTest;
import corp.bi.go.id.api.pintar.application.config.ClientServiceTestConfig;
import corp.bi.go.id.api.pintar.facade.response.AllKhazanah;
import corp.bi.go.id.api.pintar.facade.response.Khazanah;
import org.junit.Test;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(ClientServiceTestConfig.class)
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

    @Test
    public void getAllKhazanah_success() throws Exception {
        ApiResponse<AllKhazanah> response = get("/khazanah/all", AllKhazanah.class);
        assertEquals(response.getResponseCode(), "1000");
        assertEquals(response.getResponseMessage(), "success");

        AllKhazanah responseData = response.getResponseData();
        assertEquals(responseData.getKhazanahList().stream().count(), 3);
        assertEquals(responseData.getKhazanahList().get(0).getId(), "0B503C70-6F78-4F44-A060-1A000D6CB0E6");
    }
}