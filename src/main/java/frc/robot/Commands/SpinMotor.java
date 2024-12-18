// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.time.Duration;
import java.time.Instant;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.MotorSubsystem;

public class SpinMotor extends Command {

	private Instant m_startTime;
	private final MotorSubsystem m_motorSubsystem;

	/** Creates a new SpinMotor. */
	public SpinMotor(MotorSubsystem motorSubsystem) {
		m_motorSubsystem = motorSubsystem;
		// Use addRequirements() here to declare subsystem dependencies.
		addRequirements(m_motorSubsystem);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		m_startTime = Instant.now();
		m_motorSubsystem.setSpeed(0.1);
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		m_motorSubsystem.setSpeed(0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		if (Duration.between(m_startTime, Instant.now()).toMillis() > 10000) {
			return true;
		}
		return false;
	}
}