package com.officehub.officehubserver.OfficeHubServer.service;

import com.officehub.officehubserver.OfficeHubServer.dto.MeetingRoomReservationDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PostMeetingRoomReservationDto;
import com.officehub.officehubserver.OfficeHubServer.exception.AlreadyBookedInTimeException;
import com.officehub.officehubserver.OfficeHubServer.exception.IdNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.exception.WrongTimeRangeException;
import com.officehub.officehubserver.OfficeHubServer.repository.MeetingRoomReservationMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MeetingRoomReservationServiceImpl implements MeetingRoomReservationService{

    private final MeetingRoomReservationMapper meetingRoomReservationMapper;

    public MeetingRoomReservationServiceImpl(MeetingRoomReservationMapper meetingRoomReservationMapper) {
        this.meetingRoomReservationMapper = meetingRoomReservationMapper;
    }

    @Override
    public List<MeetingRoomReservationDto> getAllReservationListByDate(LocalDate reservationDate) {
        // 날짜 입력 패턴이 잘못됬을 때

        return meetingRoomReservationMapper.getAllReservationListByDate(reservationDate);
    }

    @Override
    public void bookMeetingRoom(PostMeetingRoomReservationDto postMeetingRoomReservationDto) {
        // WrongTimeRangeException
        int startHour = postMeetingRoomReservationDto.getStartHour();
        int endHour = postMeetingRoomReservationDto.getEndHour();
        if (startHour >= endHour) {
            throw new WrongTimeRangeException("wrong request : time range");
        }

        // IdNotFoundException : roomId
        int roomId = postMeetingRoomReservationDto.getRoomId();
        int roomCount = meetingRoomReservationMapper.getMeetingRoomCountById(roomId);
        if (roomCount == 0) {
            throw new IdNotFoundException("roomId not found");
        }

        // IdNotFoundException : subscriberId
        int subscriberId = postMeetingRoomReservationDto.getSubscriberId();
        int employeeCount = meetingRoomReservationMapper.getEmployeeCountById(subscriberId);
        if (employeeCount == 0) {
            throw new IdNotFoundException("employeeId not found");
        }

        // AlreadyBookedInTimeException
        int wrongCount = meetingRoomReservationMapper.checkReservationOverlap(postMeetingRoomReservationDto);
        if (wrongCount > 0) {
            throw new AlreadyBookedInTimeException("already booked in time");
        }

        meetingRoomReservationMapper.bookMeetingRoom(postMeetingRoomReservationDto);
    }

    @Override
    public List<MeetingRoomReservationDto> getMeetingRoomReservationListByEmployeeId(int subscriberId) {
        // IdNotFoundException : employeeId
        int employeeIdCount = meetingRoomReservationMapper.getEmployeeCountById(subscriberId);
        if (employeeIdCount == 0) {
            throw new IdNotFoundException("employeeId not found");
        }

        return meetingRoomReservationMapper.getMeetingRoomReservationListByEmployeeId(subscriberId);
    }

    @Override
    public void deleteMeetingRoomReservation(int reservationId) {
        // IdNotFoundException
        int count = meetingRoomReservationMapper.getMeetingRoomReservationByReservationId(reservationId);
        if (count == 0) {
            throw new IdNotFoundException("id not found");
        }

        meetingRoomReservationMapper.deleteMeetingRoomReservation(reservationId);
    }
}
