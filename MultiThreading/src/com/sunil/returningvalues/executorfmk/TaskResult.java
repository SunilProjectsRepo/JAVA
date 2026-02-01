package com.sunil.returningvalues.executorfmk;

import java.util.Objects;

public class TaskResult<S, R> {
	public final S taskId;
	public final R result;
	
	public TaskResult(S taskId, R result) {
		this.taskId = taskId;
		this.result = result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(result, taskId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskResult other = (TaskResult) obj;
		return Objects.equals(result, other.result) && Objects.equals(taskId, other.taskId);
	}

	@Override
	public String toString() {
		return "=====TaskResult [taskId=" + taskId + ", result=" + result + "]=====";
	}

	
}
