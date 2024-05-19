package io.swyp.luckybackend.luckyDays.domain;

import io.swyp.luckybackend.users.domain.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "LC_DAY_CYCLE")
public class LcDayCycleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CYCL_NO", nullable = false)
    private Long cyclNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NO", nullable = false)
    private UserEntity user;

    @Column(name = "COUNT")
    private Integer count;

    @Column(name = "PERIOD")
    private Integer period;

    @Column(name = "START_DT")
    @Temporal(TemporalType.DATE)
    private Date startDt;

    @Column(name = "END_DT")
    @Temporal(TemporalType.DATE)
    private Date endDt;

    @Column(name = "EXPT_DT", columnDefinition = "TEXT")
    private String exptDt;

    @Column(name = "RESET", length = 1, columnDefinition = "CHAR DEFAULT 'N'")
    private String reset;

    @OneToMany(mappedBy = "cycl", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LcDayDtlEntity> dtls = new ArrayList<>();

    @Builder
    public LcDayCycleEntity(UserEntity user, Integer count, Integer period, Date startDt, Date endDt, String exptDt, String reset) {
        this.user = user;
        this.count = count;
        this.period = period;
        this.startDt = startDt;
        this.endDt = endDt;
        this.exptDt = exptDt;
        this.reset = reset;
    }

    @Override
    public String toString() {
        return "LcDayCycleEntity{" +
                "cyclNo=" + cyclNo +
                ", user=" + user.getUserNo() +
                ", count=" + count +
                ", period=" + period +
                ", startDt=" + startDt +
                ", endDt=" + endDt +
                ", exptDt='" + exptDt + '\'' +
                ", reset='" + reset + '\'' +
                ", dtls=" + dtls +
                '}';
    }
}
