// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Commands.SpinMotor;
import frc.robot.Subsystems.MotorSubsystem;

public class RobotContainer {
	private MotorSubsystem m_motorSubsystem = new MotorSubsystem();

	public RobotContainer() {
		configureBindings();
	}

	private void configureBindings() {
	}

	public Command getAutonomousCommand() {
		return new SpinMotor(m_motorSubsystem);
	}
}
