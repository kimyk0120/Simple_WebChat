package com.toypwebchat.toyp_webchat.webchat.controller;

import com.toypwebchat.toyp_webchat.webchat.common.dto.BasicResponse;
import com.toypwebchat.toyp_webchat.webchat.common.dto.CommonResponse;
import com.toypwebchat.toyp_webchat.webchat.model.Room;
import com.toypwebchat.toyp_webchat.webchat.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/chatRooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /***
     * 채팅방 목록 페이지 VIEW
      * @param request
     * @return
     */
    @GetMapping("")
    public String chatRooms(HttpServletRequest request) {
        return "content/chatRooms";
    }

    /***
     * 채팅방 목록 조회
     * @param request
     * @return
     */
    @GetMapping("/getRooms")
    public @ResponseBody List<Room> getRooms(HttpServletRequest request) {
        return roomService.getRooms();
    }


    /***
     * 채팅방 생성
     * @param request
     * @return
     */
    @PostMapping("/createRoom")
    public @ResponseBody ResponseEntity<? extends BasicResponse> createRoom(HttpServletRequest request, @RequestBody Map<String, String> roomName) {
        Room room = roomService.createRoom(roomName.get("roomName"));
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse<>(room));
    }

    /***
     * 채팅방 페이지 VIEW
     * @param request
     * @return
     */
    @GetMapping("/room/{roomId}")
    public ModelAndView chatRoom(HttpServletRequest request, @PathVariable String roomId, ModelAndView mv){
        Room room = roomService.joinRoom(roomId);
        mv.addObject("room", room);
        mv.setViewName("content/chatRoom");
        return mv;
    }

}//.class
