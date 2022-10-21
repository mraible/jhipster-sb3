package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class ProjectEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProjectEntity.class);
        ProjectEntity projectEntity1 = new ProjectEntity();
        projectEntity1.setId(1L);
        ProjectEntity projectEntity2 = new ProjectEntity();
        projectEntity2.setId(projectEntity1.getId());
        assertThat(projectEntity1).isEqualTo(projectEntity2);
        projectEntity2.setId(2L);
        assertThat(projectEntity1).isNotEqualTo(projectEntity2);
        projectEntity1.setId(null);
        assertThat(projectEntity1).isNotEqualTo(projectEntity2);
    }
}
