package org.example.controller;

import org.example.constants.SortType;
import org.example.service.AbstractSorting;
import org.example.service.FileReader;
import org.example.service.SortFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class SortControllerTest {

    @Mock
    private SortFactory sortFactory;

    @Mock
    private FileReader fileReader;

    @Mock
    private AbstractSorting abstractSorting;

    @InjectMocks
    private SortController sortController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(sortController).build();
    }

    @Test
    public void testSortArray() throws Exception {
        SortType sortType = SortType.BUBBLE;

        int[] unsortedArray = {5, 2, 7, 1, 3};
        double elapsedTime = 0.123456;

        Mockito.when(sortFactory.createSort(sortType)).thenReturn(abstractSorting);
        Mockito.when(fileReader.getArray(Mockito.any())).thenReturn(unsortedArray);
        Mockito.when(abstractSorting.sortWithElapsedTime(unsortedArray)).thenReturn(elapsedTime);

        MockMultipartFile file = new MockMultipartFile("file", "test.txt",
                String.valueOf(MediaType.MULTIPART_FORM_DATA), "5, 2, 7, 1, 3".getBytes());

        mockMvc.perform(multipart("/api/v1/sort/bubble").file(file))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"sortedArray\": [1, 2, 3, 5, 7], " +
                        "\"duration\": \"0.123456 seconds\"}"));


        Mockito.verify(sortFactory).createSort(sortType);
        Mockito.verify(fileReader).getArray(Mockito.any());
        Mockito.verify(abstractSorting).sortWithElapsedTime(unsortedArray);
    }
}