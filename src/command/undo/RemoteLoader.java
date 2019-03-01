package command.undo;

public class RemoteLoader {
 
	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

		// Light
		Light livingRoomLight = new Light("Living Room");

		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

		DimmerLightOnCommand dimmerLightOn = new DimmerLightOnCommand(livingRoomLight);
		DimmerLightOffCommand dimmerLightOff = new DimmerLightOffCommand(livingRoomLight);

		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, dimmerLightOn, dimmerLightOff);

		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		// Ceiling Fan
		CeilingFan ceilingFan = new CeilingFan("Living Room");

		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(3, ceilingFanHigh, ceilingFanOff);

		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		remoteControl.onButtonWasPushed(3);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
	}
}
