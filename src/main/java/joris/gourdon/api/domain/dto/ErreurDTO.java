package joris.gourdon.api.domain.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record ErreurDTO(
		int statusCode,
		String message,
		Map<String, String> details,
		LocalDateTime timestamp
) {}