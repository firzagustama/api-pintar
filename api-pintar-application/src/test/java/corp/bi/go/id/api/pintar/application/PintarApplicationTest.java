package corp.bi.go.id.api.pintar.application;

import corp.bi.go.id.ap.plugin.facade.request.ApiRequest;
import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.api.pintar.application.config.KhazanahFacadeTestConfig;
import corp.bi.go.id.api.pintar.application.facade.KhazanahFacadeTest;
import corp.bi.go.id.api.pintar.application.mock.KhazanahServiceGrpcMock;
import corp.bi.go.id.api.pintar.service.KhazanahService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public abstract class PintarApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    protected <T> ApiResponse<T> get(String url, Class<T> clazz) throws Exception {
        String responseJson = mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        return ApiResponse.fromJson(responseJson, clazz);
    }

    protected <T> ApiResponse<T> post(String url, ApiRequest request, Class<T> clazz) throws Exception {
        String responseJson = mockMvc.perform(MockMvcRequestBuilders.post(url).content(request.toJson()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        return ApiResponse.fromJson(responseJson, clazz);
    }
}
